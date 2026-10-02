https://www.datasparc.com/online-sql-editor/

SELECT dept_no, MAX(salary) AS highest_salary
FROM Employee
GROUP BY dept_no
ORDER BY dept_no;