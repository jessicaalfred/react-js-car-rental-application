const mongoose = require("mongoose");

function connectDB() {
  mongoose.connect(
    "mongodb+srv://dbuser:dbpassword@pathberries-backend.jxlzr.mongodb.net/?retryWrites=true&w=majority",
    { useUnifiedTopology: true, useNewUrlParser: true }
  );

  const connection = mongoose.connection;

  connection.on("connected", () => {
    console.log("Postgresql Connection Successfull");
  });

  connection.on("error", () => {
    console.log("Postgresql Connection Error");
  });
}

connectDB();

module.exports = mongoose;
