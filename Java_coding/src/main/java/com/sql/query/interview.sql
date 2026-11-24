https://www.datasparc.com/online-sql-editor/

SELECT dept_no, MAX(salary) AS highest_salary
FROM Employee
GROUP BY dept_no
ORDER BY dept_no;

/*3rd Highest Salary Employee in PostgreSQL
OFFSET 2 skips the top 2, LIMIT 1 returns the 3rd.
*/
SELECT * FROM employees ORDER BY salary DESC LIMIT 1 OFFSET 2;

/*Duplicates Where ALL Columns Are Identical*/
DELETE FROM employees a
WHERE EXISTS (
    SELECT 1
    FROM employees b
    WHERE a.ctid > b.ctid
      AND a.id = b.id
      AND a.name = b.name
      AND a.email = b.email
      AND a.salary = b.salary
      AND a.department = b.department
      -- add all columns
);   

DELETE FROM employees e
WHERE id NOT IN (
    SELECT MIN(id)
    FROM employees
    GROUP BY name, email, salary
);

/*Count orders per customer, including customers with none */
SELECT c.customer_id, c.name, COUNT(o.order_id) AS order_count
FROM customer c
LEFT JOIN orders o ON o.customer_id = c.customer_id
GROUP BY c.customer_id, c.name;

/*Find the second-highest salary in each department*/
SELECT department_id, salary
FROM (
    SELECT department_id,
           salary,
           DENSE_RANK() OVER (
               PARTITION BY department_id
               ORDER BY salary DESC
           ) AS salary_rank
    FROM employees
) ranked
WHERE salary_rank = 2;

/**SQL
payments
--------
payment_id
customer_id
amount
status
created_at
 
accounting
----------
payment_id
accounting_status
accounted_at */

/*Successful Payments Without Accounting Records */
SELECT 
    p.payment_id,
    p.customer_id,
    p.amount,
    p.status,
    p.created_at
FROM payments p
WHERE p.status = 'success'
  AND NOT EXISTS (
      SELECT 1
      FROM accounting a
      WHERE a.payment_id = p.payment_id
        AND a.accounting_status = 'success'
  );
/*Highest Successful Unaccounted Payment Per Customer */

WITH unaccounted_payments AS (
    SELECT 
        p.payment_id,
        p.customer_id,
        p.amount,
        p.created_at,
        ROW_NUMBER() OVER (
            PARTITION BY p.customer_id 
            ORDER BY p.amount DESC, p.created_at DESC
        ) AS rn
    FROM payments p
    WHERE p.status = 'success'
      AND NOT EXISTS (
          SELECT 1
          FROM accounting a
          WHERE a.payment_id = p.payment_id
            AND a.accounting_status = 'success'
      )
)
SELECT 
    customer_id,
    payment_id,
    amount AS highest_unaccounted_amount,
    created_at
FROM unaccounted_payments
WHERE rn = 1;