package com.idm.moviedb.utils

import com.idm.moviedb.models.Movie
import com.idm.moviedb.models.TVShow

object Dummy {

    fun getMovie(): ArrayList<Movie> {
        val listMovie = ArrayList<Movie>()

        listMovie.add(
            Movie(
                "Alita: Battle Angel ",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg",
                "Action, Science Fiction, Adventure",
                72,
                "2h 2m",
                "Robert Rodriguez",
                170000000,
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past."
            )
        )

        listMovie.add(
            Movie(
                "Aquaman",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg",
                "Action, Adventure, Fantasy",
                69,
                "2h 23m",
                "James Wan",
                160000000,
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne."
            )
        )

        listMovie.add(
            Movie(
                "A Star Is Born",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg",
                "Drama, Romance, Music",
                75,
                "2h 16m",
                "Bradley Cooper",
                36000000,
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons."
            )
        )
        listMovie.add(
            Movie(
                "Bohemian Rhapsody",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                "Music, Drama, History",
                80,
                "2h 15m",
                "Bryan Singer",
                52000000,
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess."
            )
        )
        listMovie.add(
            Movie(
                "Cold Pursuit",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
                "Action, Crime, Thriller",
                57,
                "1h 59m",
                "Hans Petter Moland",
                60000000,
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution."
            )
        )
        listMovie.add(
            Movie(
                "Creed II",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg",
                "Drama",
                69,
                "2h 10m",
                "Steven Caple Jr.",
                50000000,
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life."
            )
        )
        listMovie.add(
            Movie(
                "Glass",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
                "Thriller, Drama, Science Fiction",
                67,
                "2h 9m",
                "M. Night Shyamalan",
                20000000,
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men."
            )
        )
        listMovie.add(
            Movie(
                "How to Train Your Dragon",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg",
                "Animation, Family, Adventure",
                78,
                "1h 44m",
                "Dean DeBlois",
                29000000,
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind."
            )
        )
        listMovie.add(
            Movie(
                "Avengers: Infinity War",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                "Adventure, Action, Science Fiction",
                83,
                "2h 29m",
                "Joe Russo",
                300000000,
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain."
            )
        )
        listMovie.add(
            Movie(
                "Mary Queen of Scots",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/b5RMzLAyq5QW6GtN9sIeAEMLlBI.jpg",
                "Drama, History",
                66,
                "2h 4m",
                "Josie Rourke",
                25000000,
                "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled."
            )
        )
        return listMovie

    }

    fun getTvShow():ArrayList<TVShow> {
        val listTvShow = ArrayList<TVShow>()

        listTvShow.add(
            TVShow(
                "Arrow",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
                "Crime, Drama, Mystery, Action & Adventure",
                66,
                "42m",
                "Greg Berlanti",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow."
            )
        )
        listTvShow.add(
            TVShow(
                "Dragon Ball",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/tZ0jXOeYBWPZ0OWzUhTlYvMF7YR.jpg",
                "Animation, Action & Adventure",
                81,
                "25m",
                "Akira Toriyama",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish."
            )
        )
        listTvShow.add(
            TVShow(
                "Fairy Tail",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/jsYTctFnK8ewomnUgcwhmsTkOum.jpg",
                "Action & Adventure, Animation, Comedy",
                78,
                "25m",
                "Hiro Mashima",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail."
            )
        )
        listTvShow.add(
            TVShow(
                "Family Guy",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/eWWCRjBfLyePh2tfZdvNcIvKSJe.jpg",
                "Animation, Comedy",
                70,
                "22m",
                "Seth MacFarlane ",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues."
            )
        )
        listTvShow.add(
            TVShow(
                "Gotham",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg",
                "Drama, Crime, Sci-Fi & Fantasy",
                75,
                "43m",
                "Bruno Heller",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?"
            )
        )
        listTvShow.add(
            TVShow(
                "Hanna",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/iYUtjx1EN4SVTgxd2TB4cZTGSQb.jpg",
                "Action & Adventure, Drama",
                75,
                "50m",
                "David Farr",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film."
            )
        )
        listTvShow.add(
            TVShow(
                "Marvel's Iron Fist",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4l6KD9HhtD6nCDEfg10Lp6C6zah.jpg",
                "Action & Adventure, Drama, Sci-Fi & Fantasy",
                66,
                "55m",
                "Scott Buck",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny."
            )
        )
        listTvShow.add(
            TVShow(
                "NCIS",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fi8EvaWtL5CvoielOjjVvTr7ux3.jpg",
                "Crime, Action & Adventure, Drama",
                74,
                "45m",
                "Donald P. Bellisario, Don McGill",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position."
            )
        )
        listTvShow.add(
            TVShow(
                "Riverdale",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                "Mystery, Drama, Crime",
                86,
                "45m",
                "Roberto Aguirre-Sacasa",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade."
            )
        )
        listTvShow.add(
            TVShow(
                "Shameless",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/9akij7PqZ1g6zl42DQQTtL9CTSb.jpg",
                "Drama, Comedy",
                80,
                "57m",
                "Paul Abbott",
                "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be... perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any family you know, but they make no apologies for being exactly who they are."
            )
        )
        return listTvShow

    }

}