delimiter //
create trigger delete_all_user_info
after delete on `users`
for each row
begin
	delete from resumes where user_id = old.id;
	delete from mailbox where from_id = old.id or for_id = old.id;
	delete from project_requests where for_whom_id = old.id;
	delete from user_requests where user_id = old.id;
	delete from projects where leader_id = old.id and count = 1;
	update projects set count = count - 1 where projects.id = users_in_projects.proj_id and users_in_projects.user_id = old.id and
	leader_id <> old.id;
	update projects set leader_id = (select user_id from users_in_projects where proj_id = projects.id and user_is = min(user_id)) and
	count = count - 1 where leader_id = old.id;
	delete from users_in_projects where user_id = old.id;
end
// delimiter ;

delimiter //
create trigger update_project_count
after insert on `users_in_projects`
for each row
begin
	update projects set count = count + 1 where projects.id=new.users_in_projects.proj_id;
end
// delimiter ;

delimiter //
create trigger delete_all_project_data
after delete on `projects`
for each row
begin
	delete from project_requests where proj_id = old.id;
	delete from user_requests where proj_id = old.id;
	delete from announcements where proj_id = old.id;
	delete from users_in_projects where proj_id = old.id;
end
// delimiter ;

delimiter //
create trigger update_users_in_projects
after insert on `projects`
for each row
begin
	insert into users_in_projects (user_id, proj_id) values (new.projects.leader_id, new.projects.id);
end
// delimiter ;