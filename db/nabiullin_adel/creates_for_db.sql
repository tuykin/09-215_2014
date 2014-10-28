create table Users (
	id int unsigned not null auto_increment primary key,
	login varchar(20) not null,
	first_name varchar(45) not null,
	last_name varchar(45) not null,
	birth_date date not null,
	e_mail varchar(45) not null,
	ph_number varchar(20) not null, /*of course, contains only the digits*/
	sex varchar(1) not null /*'m' or 'w'*/
);

create table Passwords (
	user_id int unsigned not null unique,
	password varchar(16) not null,
	constraint fk_userid_in_passwords foreign key (user_id) references Users (id)
);

create table Resumes (
	id int unsigned not null auto_increment unique,
	user_id int unsigned not null,
	position varchar(45) not null,
	work_exp int not null, /*in months*/
	prof_skills tinytext not null, /*skills that are important for this position*/
	some_inf text, /*some information about recent jobs, projects and maybe smth. else*/
	constraint fk_userid_in_resumes foreign key (user_id) references Users (id)
);

create table Projects (
	id int unsigned not null auto_increment primary key,
	proj_name varchar(60) not null,
	leader_id int unsigned not null, /*team leader's id*/
	count smallint unsigned not null, /*current number of participants*/
	constraint fk_leaderid_in_projects foreign key (leader_id) references Users (id)
);

create table Announcements (
	id int unsigned not null auto_increment unique,
	proj_id int unsigned not null,
	position varchar(45) not null,
	constraint fk_projid_in_annoucements foreign key (proj_id) references Projects (id)
);

create table Users_in_Projects (
	id int unsigned not null auto_increment unique,
	user_id int unsigned not null,
	proj_id int unsigned not null,
	constraint fk_userid_in_uspr foreign key (user_id) references Users (id),
	constraint fk_projid_in_uspr foreign key (proj_id) references Projects (id)
);

create table User_Requests (
	id int unsigned not null auto_increment unique,
	user_id int unsigned not null,
	proj_id int unsigned not null,
	constraint fk_userid_in_usrequests foreign key (user_id) references Users (id),
	constraint fk_projid_in_usrequests foreign key (proj_id) references Projects (id)
);

create table Project_Requests (
	id int unsigned not null auto_increment unique,
	proj_id int unsigned not null,
	for_whom_id int unsigned not null,
	constraint fk_projid_in_leaderrequests foreign key (proj_id) references Projects (id),
	constraint fk_forwhomid_in_leaderrequests foreign key (for_whom_id) references Users (id)
);