package test;



    enum Signal {
        GREEN, YELLOW, RED
    }

    public class TrafficLight {
        Signal color = Signal.RED;

        public void change() {
            switch (color) {
                case RED:
                    color = Signal.GREEN;
                    break;
                case YELLOW:
                    color = Signal.RED;
                    break;
                case GREEN:
                    color = Signal.YELLOW;
                    break;
            }
        }

        public static void main(String[] args){
            TrafficLight t = new TrafficLight();
            System.out.print(t.color);
            if(t.color == Signal.RED){
                System.out.print("111");
            }
        }
    }

