
    public class Console {

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


