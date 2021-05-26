package com.avszoom.ratingdataservice.resources;

import com.avszoom.ratingdataservice.models.Rating;
import com.avszoom.ratingdataservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingDataResource {
    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId, 4);
    }

    /*
    *  returning list is not a good option as adding a new field will be challenge in future while having an object
    *  can easily add a new field without breaking any existing contract.
    * */
    @RequestMapping("users/{userId}")
    public UserRating getRatingsForUser(@PathVariable("userId") String userId){
        List<Rating> ratings = Arrays.asList(new Rating("123",4),
                new Rating("212",4));
        return new UserRating(ratings);
    }
}
