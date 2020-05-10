# FKPayrollDesign
## Flipkart Java Assessment Repository

  __The following Java Payroll Design is basically made with the following purposes:__
      *Identify Types and Define Types
      Design Role and Responsibilities
      Design Towards Single Responsibility
      Design Towards Loose Coupling
      Design For Changeability and Future Requirements
      Evaluate Various Design Choices and Reason/Prove It
      Define Design Objectives and Approaches
      Appreciating Design Thinking
      Drive Design By Convention vs. Configurations
      Design By Contracts
      Drive Design By Definitions
          Design with Types
          Design For Localisation/Encapsulation
          Design For Invariance/Polymorphism
          Design For Evolution/Extension and Change
      Appreciating OOAD in Java
      Representing Design in UML Diagrams
      Writing Design Document
      Exploring Design Strategies, Discussing and Reasoning Design*
      
    **The Main Features as Implemented in Various Commits include**
    
            ●Some employees work by the hour. They are paid an hourly rate that is one of the
            fields in their employee record. They submit daily time cards that record the date
            and the number of hours worked. If they work more than 8 hours per day, they
            are paid 1.5 times their normal rate for those extra hours. They are paid every
            Friday.
            ● Some employees are paid a flat salary. They are paid on the last working day of
            the month. Their monthly salary is one of the fields in their employee record.
            ● Some of the salaried employees are also paid a commission based on their sales.
            They submit sales receipts that record the date and the amount of the sale. Their
            commission rate is a field in their employee record. They are paid every other
            Friday.
            ● Employees can select their method of payment. They may have their paychecks
            mailed to the postal address of their choice; they may have their paychecks held
            for pickup by the paymaster; or they can request that their paychecks be directly
            deposited into the bank account of their choice.
            ● Some employees belong to the employee union. Their employee record has a field
            for the weekly dues rate for union. Their dues must be deducted from their pay.
            Also, the union may assess service charges e.g. membership fee, festival fees etc.
            against individual union members from time to time. These service charges are
            submitted by the union on a weekly basis and must be deducted from the
            appropriate employee’s next pay amount.
            ●
            The payroll application will run once each working day and pay the appropriate
            employees on that day. The system will be told to what date the employees are to
            be paid, so it will generate payments for records from the last time the employee
            was paid up to the specified date.
