package com.example.Telegram_mby.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Logging {

    @Column
    public Timestamp timeSave;
    @Column
    public Timestamp timeUpdate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "logging")
    private Person person;

}
