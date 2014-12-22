create table instructorsandlessons(

instructor_id int not null,
section_id int not null,
constraint fk_instructor_id_ial_ins
foreign key(instructor_id)
references instructors(id)
on delete cascade
on update cascade,
constraint fk_section_id_ial_sec
foreign key(section_id)
references sections(id)
on delete cascade
on update cascade

);