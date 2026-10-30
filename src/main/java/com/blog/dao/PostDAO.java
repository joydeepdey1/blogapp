package com.blog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostDAO {

    // Method to get a connection to the database
    private Connection getConnection() throws SQLException, ClassNotFoundException {
        // Step 1: Register the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Step 2: Establish the connection
        String url = "jdbc:mysql://localhost:3306/fsjv_july?serverTimezone=UTC";
        String username = "root";
        String password = ""; // Default password for XAMPP is empty

        Connection con = DriverManager.getConnection(url, username, password);
        return con;
    }

    // Method to save a new post to the database
    public boolean createPost(String title, String content) {
        String sql = "INSERT INTO posts (post_title, post_content) VALUES (?, ?)";
        
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            // Step 3: Set the parameter values
            ps.setString(1, title);
            ps.setString(2, content);

            // Step 4: Execute the query
            int rowsAffected = ps.executeUpdate();

            // Return true if the insert was successful
            return rowsAffected > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); // Print the error for debugging
            return false;
        }
    }
 // Add this new method to your PostDAO.java file
    public java.util.List<Post> getAllPosts() {
        java.util.List<Post> posts = new java.util.ArrayList<>();
        String sql = "SELECT * FROM posts ORDER BY post_date DESC"; // Get newest posts first

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             java.sql.ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Post post = new Post();
                post.setId(rs.getInt("post_id"));
                post.setTitle(rs.getString("post_title"));
                post.setContent(rs.getString("post_content"));
                post.setPostDate(rs.getTimestamp("post_date"));
                posts.add(post);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return posts;
    }
}