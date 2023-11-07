package agh.ics.oop.model;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    @Override
    public String toString() {
        switch (this) {
            case NORTH -> {
                return "Północ";
            }
            case SOUTH -> {
                return "Południe";
            }
            case EAST -> {
                return "Wschód";
            }
            case WEST -> {
                return "Zachód";
            }
            default -> {
                return "Nieznany kierunek";
            }
            }
        }
        public MapDirection  next() {
            switch (this) {
                case NORTH -> {
                    return EAST;
                }
                case SOUTH -> {
                    return WEST;
                }
                case EAST -> {
                    return SOUTH;
                }
                case WEST -> {
                    return NORTH;
                }
                default -> {
                    return this;
                }
            }
        }
    public MapDirection  previous() {
        switch (this) {
            case NORTH -> {
                return WEST;
            }
            case SOUTH -> {
                return EAST;
            }
            case EAST -> {
                return NORTH;
            }
            case WEST -> {
                return SOUTH;
            }
            default -> {
                return this;
            }
        }
    }
 public Vector2d toUnitVector() {
     switch (this) {
         case NORTH -> {
             return new Vector2d(1, 0);
         }
         case SOUTH -> {
             return new Vector2d(-1, 0);
         }
         case EAST -> {
             return new Vector2d(0, 1);
         }
         case WEST -> {
             return new Vector2d(0, -1);
         }
         default -> {
             return new Vector2d(0, 0);
         }
     }
    }
    }
