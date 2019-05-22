/*
Author : Sathyanarayanan
Purpose : This file queries OMDB API based on Movie Name
*/
// http://www.omdbapi.com/?t=terminator&apikey=f4cba32c

def queryomdb() {
    def baseURL = 'http://www.omdbapi.com/'
    def apikey = 'f4cba32c'
    println "Please input Movie Name to Query"
    def movieName = System.in.newReader().readLine()

    println "Running Query"
    run = """
    curl "${baseURL}\\?t=${movieName}&apikey=${apikey}"
    """  
    run = run.execute().text
    println run.split(',')
}

queryomdb()