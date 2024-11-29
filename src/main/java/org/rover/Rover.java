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

    private static boolean moveForward(String command) {
        return command.equals("f");
    }

    private static boolean shouldRotate(String command) {
        return command.equals("l") || command.equals("r");
    }

    public void receive(String commandsSequence) {
        for (int i = 0; i < commandsSequence.length(); ++i) {
            String command = commandsSequence.substring(i, i + 1);

            if (shouldRotate(command)) {
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

        if (moveForward(command)) {
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
            case "N" -> direction = command.equals("r") ? "E" : "W";
            case "S" -> direction = command.equals("r") ? "W" : "E";
            case "W" -> direction = command.equals("r") ? "N" : "S";
            default -> direction = command.equals("r") ? "S" : "N";
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