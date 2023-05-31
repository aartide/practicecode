CREATE TABLE emp (
	employee_id INT (11) AUTO_INCREMENT PRIMARY KEY,
	emp_name VARCHAR (20) DEFAULT NULL,
	emp_gender VARCHAR (10) NOT NULL,
	emp_pf int (1) NOT NULL ,
	emp_gratutiy int (1) NOT NULL,
    emp_NPS int (1) NOT NULL,
    emp_mediclaim int (1) NOT NULL,
    emp_meal int (1) NOT NULL,
	OfficeLocation VARCHAR(20) Default NULL,
    emp_salary integer(10) Not NUll,
    emp_address VARCHAR(100) not NULL);


INSERT INTO qa.emp
(emp_name, emp_gender, emp_pf, emp_gratutiy, emp_NPS, emp_mediclaim, emp_meal, OfficeLocation, emp_salary, emp_address)
VALUES('trupti', 'female', 0, 1, 0, 1, 0, 'Pune', 1000, 'kothrud');

SELECT employee_id, emp_name, emp_gender, emp_pf, emp_gratutiy, emp_NPS, emp_mediclaim, emp_meal, OfficeLocation, emp_salary, emp_address
FROM qa.emp;

UPDATE qa.emp
SET emp_pf=1, emp_gratutiy=1, emp_NPS=1, emp_mediclaim=1, emp_meal=1, WHERE employee_id=2;

DELETE FROM qa.emp
WHERE employee_id=2;