create trigger nol_on_delete on numberoflessons
after delete
as begin
	update sections
		set currPeopleCount = currPeopleCount-1
		from deleted
		where section_id = sections.id
	end