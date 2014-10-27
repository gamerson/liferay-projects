create table Todo_todo (
	uuid_ VARCHAR(75) null,
	todoId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	finished BOOLEAN,
	dueDate DATE null,
	description VARCHAR(75) null
);

create table Todos_Todo (
	uuid_ VARCHAR(75) null,
	todoId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	finished BOOLEAN,
	dueDate DATE null,
	description VARCHAR(75) null
);

create table todo_Todo (
	uuid_ VARCHAR(75) null,
	todoId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	finished BOOLEAN,
	dueDate DATE null,
	description VARCHAR(75) null
);