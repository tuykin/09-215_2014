create table users (
	id int unsigned not null auto_increment primary key,
	login varchar(20) not null,
	password_hash varchar(32) not null,
	email varchar(45) not null,
	first_name varchar(45),
	last_name varchar(45),
	birth_date date,
	ph_number varchar(20), /*of course, contains only the digits*/
	sex enum('m','w') /*'m' or 'w'*/
);

create table resumes (
	id int unsigned not null auto_increment unique,
	user_id int unsigned not null,
	position varchar(45) not null,
	work_exp int not null, /*in months*/
	prof_skills tinytext not null, /*skills that are important for this position*/
	some_inf tinytext, /*some information about recent jobs, projects and maybe smth. else*/
	constraint fk_userid_in_resumes foreign key (user_id) references users (id)
);

create table projects (
	id int unsigned not null auto_increment primary key,
	proj_name varchar(60) not null,
	leader_id int unsigned not null, /*team leader's id*/
	count smallint unsigned not null, /*current number of participants*/
	constraint fk_leaderid_in_projects foreign key (leader_id) references users (id)
);

create table announcements (
	id int unsigned not null auto_increment unique,
	proj_id int unsigned not null,
	position varchar(45) not null,
	information tinytext,
	constraint fk_projid_in_annoucements foreign key (proj_id) references projects (id)
);

create table users_in_projects (
	id int unsigned not null auto_increment unique,
	user_id int unsigned not null,
	proj_id int unsigned not null,
	constraint fk_userid_in_uspr foreign key (user_id) references users (id),
	constraint fk_projid_in_uspr foreign key (proj_id) references projects (id)
);

create table user_requests (
	id int unsigned not null auto_increment unique,
	user_id int unsigned not null,
	proj_id int unsigned not null,
	constraint fk_userid_in_usrequests foreign key (user_id) references users (id),
	constraint fk_projid_in_usrequests foreign key (proj_id) references projects (id)
);

create table project_requests (
	id int unsigned not null auto_increment unique,
	proj_id int unsigned not null,
	for_whom_id int unsigned not null,
	constraint fk_projid_in_leaderrequests foreign key (proj_id) references projects (id),
	constraint fk_forwhomid_in_leaderrequests foreign key (for_whom_id) references users (id)
);

create table news (
	id int unsigned not null auto_increment unique,
	publish_date date not null,
	information tinytext not null
);

create table mailbox (
	id int unsigned not null auto_increment unique,
	from_id int unsigned not null,
	for_id int unsigned not null,
	information tinytext not null,
	send_date date not null,
	constraint fk_fromid_in_mailbox foreign key (from_id) references users (id),
	constraint fk_forid_in_mailbox foreign key (for_id) references users (id)
);