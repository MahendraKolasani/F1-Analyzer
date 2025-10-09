\copy public.circuits(id, name, location, country, lat, lng, alt, url) FROM '/path/to/artifacts/circuits.csv' CSV HEADER;
\copy public.constructors(id, name, nationality, url) FROM '/path/to/artifacts/csv/constructors.csv' CSV HEADER;
\copy public.constructor_standings(id, race_id, constructor_id, points, position, position_text) FROM '/path/to/artifacts/csv/constructor_standings.csv' CSV HEADER;
\copy public.drivers(id, driver_ref, number, code, forename, surname, dob, nationality, url) FROM '/path/to/artifacts/csv/drivers.csv' CSV HEADER;
\copy public.driver_standings(id, race_id, driver_id, points, position, position_text, wins) FROM '/path/to/artifacts/csv/driver_standings.csv' CSV HEADER;
\copy public.races(id, year, round, circuit_id, name, date, time, url, fp1_date, fp1_time, fp2_date, fp2_time, fp3_date, fp3_time, quali_date, quali_time, sprint_date, sprint_time) FROM '/path/to/artifacts/csv/races.csv' CSV HEADER;
\copy public.results(id, race_id, driver_id, constructor_id, number, grid, position, position_text, position_order, points, laps, time, milliseconds, fastest_lap, rank, fastest_lap_time, fastest_lap_speed, status_id) FROM '/path/to/artifacts/csv/results.csv' CSV HEADER;
\copy public.lap_times(id, race_id, driver_id, lap, position, time, milliseconds) FROM '/path/to/artifacts/csv/lap_times.csv' CSV HEADER;
\copy public.pit_stops(race_id, driver_id, stop, lap, time, duration, milliseconds) FROM '/path/to/artifacts/csv/pit_stops.csv' CSV HEADER;
\copy public.qualifying(id, race_id, driver_id, constructor_id, number, position, q1, q2, q3) FROM '/path/to/artifacts/csv/qualifying.csv' CSV HEADER;
\copy public.seasons(year, url) FROM '/path/to/artifacts/csv/seasons.csv' CSV HEADER;
\copy public.sprint_results(id, race_id, driver_id, constructor_id, number, grid, position, position_text, position_order, points, laps, time, milliseconds, fastest_lap, rank, fastest_lap_time, fastest_lap_speed, status_id) FROM '/path/to/artifacts/csv/sprint_results.csv' CSV HEADER;
\copy public.status(id, status) FROM '/path/to/artifacts/csv/status.csv' CSV HEADER;

