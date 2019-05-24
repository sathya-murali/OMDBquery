**About this Repo**

**This repository is for running OMDB API query to get Movie Details. This Query returns in JSon format.**

**How to Use this Project:** 
Run dockerfile which would create the docker image. This image would contain the code to run API query.

**How to Run the application:**

**Usage:** 
- Run command docker-compose run queryapi groovy ./queryOMDBAPI.groovy bash
- This would create image with Name "queryapi"
- Provide the Movie name you wanted to fetch. The movie details would be returned in JSon format.
- You do need to provide the complete name, as long the you provide near match you would get results as below.

*Example Below*


```json
Please input Movie Name to Query
avengers infinity
Running Query for avengers infinity
STDOUT {
    "Title": "Avengers: Infinity War",
    "Year": "2018",
    "Rated": "PG-13",
    "Released": "27 Apr 2018",
    "Runtime": "149 min",
    "Genre": "Action, Adventure, Sci-Fi",
    "Director": "Anthony Russo, Joe Russo",
    "Writer": "Christopher Markus (screenplay by), Stephen McFeely (screenplay by), Stan Lee (based on the Marvel comics by), Jack Kirby (based on the Marvel comics by), Joe Simon (Captain America created by), Jack Kirby (Captain America created by), Steve Englehart (Star-Lord created by), Steve Gan (Star-Lord created by), Bill Mantlo (Rocket Raccoon created by), Keith Giffen (Rocket Raccoon created by), Jim Starlin (Thanos,  Gamora and Drax created by), Stan Lee (Groot created by), Larry Lieber (Groot created by), Jack Kirby (Groot created by), Steve Englehart (Mantis created by), Don Heck (Mantis created by)",
    "Actors": "Robert Downey Jr., Chris Hemsworth, Mark Ruffalo, Chris Evans",
    "Plot": "The Avengers and their allies must be willing to sacrifice all in an attempt to defeat the powerful Thanos before his blitz of devastation and ruin puts an end to the universe.",
    "Language": "English",
    "Country": "USA",
    "Awards": "N/A",
    "Poster": "https://m.media-amazon.com/images/M/MV5BMjMxNjY2MDU1OV5BMl5BanBnXkFtZTgwNzY1MTUwNTM@._V1_SX300.jpg",
    "Ratings": [
        {
            "Source": "Internet Movie Database",
            "Value": "8.5/10"
        },
        {
            "Source": "Rotten Tomatoes",
            "Value": "85%"
        },
        {
            "Source": "Metacritic",
            "Value": "68/100"
        }
    ],
    "Metascore": "68",
    "imdbRating": "8.5",
    "imdbVotes": "641,255",
    "imdbID": "tt4154756",
    "Type": "movie",
    "DVD": "14 Aug 2018",
    "BoxOffice": "$664,987,816",
    "Production": "Walt Disney Pictures",
    "Website": "http://marvel.com/movies/movie/223/avengers_infinity_war",
    "Response": "True"
}
```

