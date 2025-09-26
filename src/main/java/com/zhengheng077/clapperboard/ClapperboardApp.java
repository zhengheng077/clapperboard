package com.zhengheng077.clapperboard;

import lombok.Setter;

/**
 * Clapperboard - 录制视频用场记板
 * A video recording clapperboard tool that can be run from command line.
 * 
 * Built with Maven, configured for JDK 25 compatibility.
 * Uses Lombok @Setter annotation for clean setter method generation.
 */
public class ClapperboardApp {
    
    public static void main(String[] args) {
        System.out.println("Clapperboard - 录制视频用场记板");
        System.out.println("==============================");
        
        // Create and configure clapperboard
        ClapperboardConfig config = new ClapperboardConfig();
        
        // Parse command line arguments
        if (args.length > 0) {
            config.setProjectName(args[0]);
        }
        if (args.length > 1) {
            config.setSceneNumber(args[1]);
        }
        if (args.length > 2) {
            config.setTakeNumber(args[2]);
        }
        if (args.length > 3) {
            config.setDirector(args[3]);
        }
        
        // Display clapperboard
        config.displayClapperboard();
        
        System.out.println("\nUsage: java -jar clapperboard.jar [project_name] [scene_number] [take_number] [director]");
    }
    
    /**
     * Configuration class for clapperboard using Lombok @Setter annotation
     */
    @Setter
    static class ClapperboardConfig {
        private String projectName = "默认项目";
        private String sceneNumber = "001";
        private String takeNumber = "001"; 
        private String director = "导演";
        
        public void displayClapperboard() {
            System.out.println();
            System.out.println("┌────────────────────────────────┐");
            System.out.println("│         CLAPPERBOARD           │");
            System.out.println("├────────────────────────────────┤");
            System.out.println("│ 项目: " + String.format("%-22s", projectName) + "│");
            System.out.println("│ 场次: " + String.format("%-22s", sceneNumber) + "│");
            System.out.println("│ 镜次: " + String.format("%-22s", takeNumber) + "│");
            System.out.println("│ 导演: " + String.format("%-22s", director) + "│");
            System.out.println("└────────────────────────────────┘");
            System.out.println();
            System.out.println("ACTION! 🎬");
        }
    }
}