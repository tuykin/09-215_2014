create trigger nol_on_insert
on numberoflessons
after insert
as begin
	update sections
		set currPeopleCount = currPeopleCount + 1
		from inserted
		where section_id = sections.id
	end