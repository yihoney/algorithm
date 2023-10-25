SELECT ai.animal_id ANIMAL_ID, ai.name NAME
from animal_ins ai inner join animal_outs ao on ai.animal_id = ao.animal_id
where ai.datetime > ao.datetime
order by ai.datetime;