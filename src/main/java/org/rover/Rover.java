package org.rover;

public class Rover {
    private String direction;
    private int y;
    private int x;

    public Rover(int x, int y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void receive(String commandsSequence) {
        for (int i = 0; i < commandsSequence.length(); ++i) {
            String command = commandsSequence.substring(i, i + 1);

            if (command.equals("l") || command.equals("r")) {
                // Rotate Rover
                if (direction.equals("N")) {
                    if (command.equals("r")) {
                        direction = "E";
                    } else {
                        direction = "W";
                    }
                } else if (direction.equals("S")) {
                    if (command.equals("r")) {
                        direction = "W";
                    } else {
                        direction = "E";
                    }
                } else if (direction.equals("W")) {
                    if (command.equals("r")) {
                        direction = "N";
                    } else {
                        direction = "S";
                    }
                } else {
                    if (command.equals("r")) {
                        direction = "S";
                    } else {
                        direction = "N";
                    }
                }
            } else {
                // Displace Rover
                int displacement1 = -1;

                if (command.equals("f")) {
                    displacement1 = 1;
                }
                int displacement = displacement1;

                if (direction.equals("N")) {
                    y += displacement;
                } else if (direction.equals("S")) {
                    y -= displacement;
                } else if (direction.equals("W")) {
                    x -= displacement;
                } else {
                    x += displacement;
                }
            }
        }
    }

    // Equals method for comparison in tests
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Rover rover = (Rover) obj;
        return y == rover.y && x == rover.x && direction.equals(rover.direction);
    }
}