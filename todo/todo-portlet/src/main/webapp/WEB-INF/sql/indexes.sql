create index IX_5804F7BF on Todo_todo (userId);
create index IX_89BE1BE5 on Todo_todo (userId, finished);
create index IX_9B18058F on Todo_todo (uuid_);
create index IX_A7D83F39 on Todo_todo (uuid_, companyId);
create unique index IX_E6A93FFB on Todo_todo (uuid_, groupId);

create index IX_59ADB498 on Todos_Todo (userId);
create index IX_C2875D7E on Todos_Todo (userId, finished);
create index IX_A367C996 on Todos_Todo (uuid_);
create index IX_E0A180D2 on Todos_Todo (uuid_, companyId);
create unique index IX_AFD813D4 on Todos_Todo (uuid_, groupId);

create index IX_D197FBFF on todo_Todo (userId);
create index IX_3388D025 on todo_Todo (userId, finished);
create index IX_5CF3794F on todo_Todo (uuid_);
create index IX_51A2F379 on todo_Todo (uuid_, companyId);
create unique index IX_4014043B on todo_Todo (uuid_, groupId);