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
