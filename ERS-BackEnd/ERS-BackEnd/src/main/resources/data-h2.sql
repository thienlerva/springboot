insert into ERS_REIMBURSEMENT (reimbursement_id, reimbursement_amount, reimbursement_submitted_date, reimbursement_description, reimbursement_author_id, reimbursement_resolver_id, reimbursement_status, reimbursement_type_id) values 
	   (1, 295.95, '2019-01-08', 'travel', 1, 20, 'Pending', 1);
insert into ERS_REIMBURSEMENT (reimbursement_id, reimbursement_amount, reimbursement_submitted_date, reimbursement_description, reimbursement_author_id, reimbursement_resolver_id, reimbursement_status, reimbursement_type_id) values 
	   (2, 395.95, '2019-01-09', 'food', 2, 21, 'Pending', 2);
insert into ERS_REIMBURSEMENT (reimbursement_id, reimbursement_amount, reimbursement_submitted_date, reimbursement_description, reimbursement_author_id, reimbursement_resolver_id, reimbursement_status, reimbursement_type_id) values 
	   (3, 495.95, '2019-01-10', 'travel', 1, 20, 'Pending', 1);
insert into USERS (user_id, first_name, last_name, user_name, password, roles) values 
			(1, 'Frank', 'Harris', 'frankharris', '123', 'Employee');
insert into USERS (user_id, first_name, last_name, user_name, password, roles)
		values (2, 'John', 'Smith', 'johnsmith', '123', 'FinanceManager');
insert into USERS (user_id, first_name, last_name, user_name, password, roles)
		values (3, 'Jenni', 'Le', 'jennile', '123', 'CEO');