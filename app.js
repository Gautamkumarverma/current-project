const express = require('express');
const app = express();
const path = require('path');

// Set the view engine to EJS
app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'check'));

// Serve static CSS files
app.use('/check/css', express.static(path.join(__dirname, 'check/css')));

// Route to render dynamic EJS files
app.get('/check/:subject/:page', (req, res) => {
  const { subject, page } = req.params;

  const filePath = path.join(subject, page); // E.g., Dbms/page1
  res.render(filePath, (err, html) => {
    if (err) {
      console.error('Error rendering file:', err.message);
      return res.status(404).send('Page not found');
    }
    res.send(html);
  });
});

// Start the server
app.listen(3000, () => {
  console.log('Server is running on http://localhost:3000');
});
