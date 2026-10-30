<%@page import="java.util.List"%>
<%@page import="com.blog.dao.Post"%>
<%@page import="com.blog.dao.PostDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Modern Blog</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

    <header>
        <h1>My Modern Blog</h1>
        <p>A place for my thoughts and ideas.</p>
    </header>

    <main>
        <div class="new-post-container">
            <a href="new-post.jsp" class="button">Create New Post</a>
        </div>
        
        <h2>Latest Posts</h2>
        
        <div class="posts-list">
            <%
                PostDAO dao = new PostDAO();
                List<Post> posts = dao.getAllPosts();
                if (posts.isEmpty()) {
            %>
                    <p>No posts yet. Be the first to write one!</p>
            <%
                } else {
                    for (Post post : posts) {
            %>
                        <article class="post-item">
                            <h3><%= post.getTitle() %></h3>
                            <p class="post-meta">Posted on <%= new java.text.SimpleDateFormat("MMMM dd, yyyy").format(post.getPostDate()) %></p>
                            <p><%= post.getContent() %></p>
                        </article>
            <%
                    }
                }
            %>
        </div>
    </main>

    <footer>
        <p>&copy; 2025 MyBlogApp</p>
    </footer>

</body>
</html>