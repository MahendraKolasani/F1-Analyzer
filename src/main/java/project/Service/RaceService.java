package project.Service;

import project.Model.RaceResultsResponse;

public interface RaceService {

    RaceResultsResponse getRaceResults(int year, int round);

}