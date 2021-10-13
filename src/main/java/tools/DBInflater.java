package tools;

import model.Artist;
import model.Song;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import repositories.ArtistRepository;
import repositories.SongRepository;

@Component
public class DBInflater implements ApplicationListener<ContextRefreshedEvent> {

    public DBInflater(SongRepository songRepository, ArtistRepository artistRepository) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
    }

    private SongRepository songRepository;
    private ArtistRepository artistRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Artist elizabeth = new Artist("Elizabeth", "Grant", "lanaDelRey");
        Song lustForLife = new Song("Lust For Life", "Love", "Brooklyn Baby",
                "Lucky Ones");
        elizabeth.getSongs().add(lustForLife);
        lustForLife.getArtists().add(elizabeth);
        artistRepository.save(elizabeth);
        songRepository.save(lustForLife);


        Artist ella = new Artist("Ella", "O'Connor", "Lorde");
        Song royals = new Song("Royals", "Team", "Solar Power",
                "Green Light");
        ella.getSongs().add(royals);
        royals.getArtists().add(ella);
        artistRepository.save(ella);
        songRepository.save(royals);



        Artist aurora = new Artist("Aurora", "Aksnes", "Aurora");
        Song runaway = new Song("Runaway", "Exist For Love", "Warrior",
                "Queendom");
        aurora.getSongs().add(runaway);
        runaway.getArtists().add(aurora);
        artistRepository.save(aurora);
        songRepository.save(runaway);

    }
}