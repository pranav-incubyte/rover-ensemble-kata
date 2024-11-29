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
                rotate(command);
            } else {
                // Displace Rover
                displace(command);
            }
        }
    }

    private void displace(String command) {
        int displacement = -1;

        if (command.equals("f")) {
            displacement = 1;
        }

        switch (direction) {
            case "N" -> y += displacement;
            case "S" -> y -= displacement;
            case "W" -> x -= displacement;
            default -> x += displacement;
        }
    }

    private void rotate(String command) {
        switch (direction) {
            case "N" -> {
                if (command.equals("r")) {
                    direction = "E";
                } else {
                    direction = "W";
                }
            }
            case "S" -> {
                if (command.equals("r")) {
                    direction = "W";
                } else {
                    direction = "E";
                }
            }
            case "W" -> {
                if (command.equals("r")) {
                    direction = "N";
                } else {
                    direction = "S";
                }
            }
            default -> {
                if (command.equals("r")) {
                    direction = "S";
                } else {
                    direction = "N";
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