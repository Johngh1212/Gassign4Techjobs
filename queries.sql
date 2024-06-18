--Part 1
/*
Part 1: List the columns and their data types in the table 'job'

+----------------+-------------+------+-----+---------+----------------+
| Field          | Type        | Null | Key | Default | Extra          |
+----------------+-------------+------+-----+---------+----------------+
| id             | int(11)     | NO   | PRI | NULL    | auto_increment |
| name           | varchar(255)| NO   |     | NULL    |                |
| employer_id    | int(11)     | YES  | MUL | NULL    |                |
| skills         | text        | YES  |     | NULL    |                |
+----------------+-------------+------+-----+---------+----------------+
*/
-- Part 2: List the names of the employers in St. Louis City
SELECT name
FROM employer
WHERE location = "St. Louis City";
--Part 3: Remove the job table
DROP TABLE job;
--Part 4: Write a query to return the names of all skills in alphabetical order.

--follows MySQL workbench
--SELECT *
--FROM skill
--LEFT JOIN job_skills ON skill.id = job_skills.skills_id|job_skills.skills_id = skill.id
--WHERE job_skills.job_id IS NOT NULL
--ORDER BY name ASC;


--follows test case
SELECT *
FROM skill
LEFT JOIN job_skills ON skill.id = job_skills.skills_id
WHERE job_skills.jobs_id IS NOT NULL
ORDER BY name ASC;