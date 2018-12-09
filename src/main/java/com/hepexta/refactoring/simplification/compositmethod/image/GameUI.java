package com.hepexta.refactoring.simplification.compositmethod.image;


public class GameUI  {
    public Image problem;
    public Image solution;
    public Image value;

    private GameUI(Image problem, Image solution, Image value) {
        this.problem = problem;
        this.solution = solution;
        this.value = value;
    }

    public static GameUI create(String problem, String solution, String value) {
        return new GameUI(new Image(problem), new Image(solution), new Image(value));
    }
}
