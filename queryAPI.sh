#!/bin/bash

# http://www.omdbapi.com/?t=terminator&apikey=f4cba32c


    baseURL='http://www.omdbapi.com/'
    apikey='f4cba32c'
    printf "Please input Movie Name to Query \n"
    read movieName
    curl "${baseURL}?t=${movieName}&apikey=${apikey}"
    printf "\n"

