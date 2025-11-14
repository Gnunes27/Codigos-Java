
    public class Console {


     // ========= CORES =========
    public static final String RESET       = "\u001B[0m";
    public static final String BLACK       = "\u001B[30m";
    public static final String RED         = "\u001B[31m";
    public static final String GREEN       = "\u001B[32m";
    public static final String YELLOW      = "\u001B[33m";
    public static final String BLUE        = "\u001B[34m";
    public static final String PURPLE      = "\u001B[35m";
    public static final String CYAN        = "\u001B[36m";
    public static final String WHITE       = "\u001B[37m";

    // ========= FUNDO =========
    public static final String BG_BLACK    = "\u001B[40m";
    public static final String BG_RED      = "\u001B[41m";
    public static final String BG_GREEN    = "\u001B[42m";
    public static final String BG_YELLOW   = "\u001B[43m";
    public static final String BG_BLUE     = "\u001B[44m";
    public static final String BG_PURPLE   = "\u001B[45m";
    public static final String BG_CYAN     = "\u001B[46m";
    public static final String BG_WHITE    = "\u001B[47m";

    // ========= ESTILOS =========
    public static final String BOLD        = "\u001B[1m";
    public static final String UNDERLINE   = "\u001B[4m";
    public static final String REVERSED    = "\u001B[7m";

    // limpa a tela via ANSI (funciona em Linux/macOS e terminais modernos)
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // pausa o programa por N milissegundos
    public static void System_sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // pausa por 1 segundo (atalho)
    public static void sleep(int s) {
        System_sleep(1000 * s);
    }

    // pausa aguardando ENTER do usuário
    public static void pause() {
        System.out.println("\nPressione ENTER para continuar...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }


}


