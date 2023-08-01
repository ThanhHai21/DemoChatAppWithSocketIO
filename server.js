const express = require("express");
const dotEnv = require("dotenv");

dotEnv.config();
const app = express();

const server = require("http").createServer(app);
const io = require("socket.io")(server);

io.on("connection", (client) => {
  console.log(`connection recieved`);

  client.on("new_message", (chat) => {
    client.emit("broadcast", chat);
  });
});

app.get("/", (req, res) => {
  res.send("Server is running");
});

const port = process.env.PORT;
server.listen(port, () => {
  console.log(`Server running port ${port}...`);
});
