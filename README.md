# Employee Reimbursement System (ERS)

## Executive Summary
The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.

**Technologies Used:**
Java, SQL, CSS, HTML, JavaScript, JUnit, Hibernate, AWS RDS, Log4J, Javalin

**Features**
Login
Employees can add Reimbursements that are persisted in a back end database
Employees can also view Reimburesements by their resolvement status
Console logs difference between Employee and Finance Manager

**Set Up**
Clone the repository onto client server with git
Import an existing Maven project into client IDE & select newly cloned folder
Create schema in database called ers_reimbursement
Run the Main class as a java application
Navigate to localhost:8081/helloFS.html

**State-chart Diagram (Reimbursement Statuses)** 
![](./imgs/state-chart.jpg)

**Reimbursement Types**

Employees must select the type of reimbursement as: LODGING, TRAVEL, FOOD, or OTHER.

**Logical Model**
![](./imgs/logical.jpg)

**Physical Model**
![](./imgs/physical.jpg)

**Use Case Diagram**
![](./imgs/use-case.jpg)

**Activity Diagram**
![](./imgs/activity.jpg)


