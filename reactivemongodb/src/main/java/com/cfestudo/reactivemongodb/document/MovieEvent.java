package com.cfestudo.reactivemongodb.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
@AllArgsConstructor
public class MovieEvent {
    @Id
    private String movieId;
    @NonNull
    private Date dateViewed;

}
