package com.mythden.mythdenbot.miniGames.Parser;

import com.mythden.mythdenbot.miniGames.service.MiniGamesService;
import com.mythden.mythdenbot.miniGames.service.MiniGamesServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MiniGamesModuleLibrary {

    private static MiniGamesService miniGamesService;

    @Autowired
    public void setServices(MiniGamesService miniGamesService){
        MiniGamesModuleLibrary.miniGamesService = miniGamesService;
    }

    /**
     * Consumes 2 arguments
     * <ul>
     * <li>{@code String title}</li>
     * <li>{@code String content}</li>
     * </ul>
     */
    public static final Module CREATE_PERTANYAAN = new Module() {
        @Override
        public Object produce() {
            return miniGamesService.createPertanyaan();
        }

        @Override
        int params() {return 0;}
    };

    public static final Module GET_PERTANYAAN = new Module() {
        @Override
        public Object produce() {
            return miniGamesService.getPertanyaan();
        }

        @Override
        int params() {return 0;}
    };

    public static final Module GET_JUMLAH_PEMAIN = new Module() {
        @Override
        public Object produce() {
            return miniGamesService.getJumlahPemain();
        }

        @Override
        int params() {return 0;}
    };

    public static final Module ADD_PEMAIN = new Module() {
        @Override
        public Object produce() {
            return miniGamesService.addPemain(args.get(0));
        }

        @Override
        int params() {return 1;}
    };

    public static final Module GET_SKOR = new Module() {
        @Override
        public Object produce() {
            return miniGamesService.getSkor();
        }

        @Override
        int params() {return 0;}
    };

    public static final Module END = new Module() {
        @Override
        public Object produce() {
            return miniGamesService.end();
        }

        @Override
        int params() {return 0;}
    };

    public static final Module GET_PEMAIN = new Module() {
        @Override
        public Object produce() {
            return miniGamesService.getPemain();
        }

        @Override
        int params() {return 0;}
    };

    public static final Module JAWAB = new Module() {
        @Override
        public Object produce() {
            return miniGamesService.jawab((String) args.get(0), (String) args.get(1));
        }

        @Override
        int params() {return 1;}
    };

    public static final Module GET_PERTANYAAN_KINI = new Module() {
        @Override
        public Object produce() {
            return miniGamesService.getPertanyaanKini();
        }

        @Override
        int params() {return 0;}
    };
}
