<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create New Post</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

    <header>
        <h1>Create a New Post</h1>
    </header>

    <main>
        <form action="createPost" method="post" class="post-form">
            <div class="form-group">
                <label for="title">Title:</label>
                <input type="text" id="title" name="postTitle" required>
            </div>
            <div class="form-group">
                <label for="content">Content:</label>
                <textarea id="content" name="postContent" rows="10" required></textarea>
            </div>
            <div class="form-group">
                <button type="submit" class="button">Publish Post</button>
            </div>
        </form>
    </main>

    <footer>
        <p>&copy; 2025 MyBlogApp</p>
    </footer>

</body>
</html>