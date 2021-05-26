package com.avszoom.moviecatalogservice.resources;

import com.avszoom.moviecatalogservice.models.CatalogItem;
import com.avszoom.moviecatalogservice.models.Movie;
import com.avszoom.moviecatalogservice.models.Rating;
import com.avszoom.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
    @Autowired
    private RestTemplate restTemplate ;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
    /*
    *  rest template is provided by spring framework , to make a call to other services, it also helps in unbinding
    *  response to an object. Its a synchronous call.
    * */


        UserRating userRating = restTemplate.getForObject("http://rating-data-service/ratingsdata/users/" + userId,
                UserRating.class);
        return userRating.getUserRatings().stream().map(rating -> {

            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getName(), "movie", rating.getRating());
        }).collect(Collectors.toList());

    }
}


/*
*  rest template is getting deperecated and webclientbuilder is async way of calling and new way, we build
*  instance of webclientbuilder. Make a chaining call
*  get response and convert it to Movie object. Mono basically tells that you will get an object in future
*  so it act as returning promise object. Something like Promise<Movie> .
*  In actuality we can return mono object to spring and tell that we will send back the real object in future
*  but if we use block() then call waits till mono is filled. SO this become sync.

Movie movie = webClientBuilder.build()
        .get()
        .uri("http://localhost:8082/movies/"+ rating.getMovieId())
        .retrieve()
        .bodyToMono(Movie.class)
        .block();

 */
