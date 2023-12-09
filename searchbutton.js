document.addEventListener("DOMContentLoaded", function () {
  document
    .querySelector(".navigation-button-1")
    .addEventListener("click", function () {
      // Retrieve values from different input fields using their respective IDs
      const surfaceValue = document.getElementById("Surface").value;
      const timeValue = document.getElementById("Time").value;
      const dateValue = document.getElementById("ChooseDate").value;
      const inOutValue = document.getElementById("In/Out").value;
      const playingHoursValue = document.getElementById("PlayingHours").value;

      // Display the retrieved values
      console.log("Surface:", surfaceValue);
      console.log("Time:", timeValue);
      console.log("Date:", dateValue);
      console.log("Indoors/Outdoors:", inOutValue);
      console.log("Playing Hours:", playingHoursValue);
      console.log("Button .navigation-button-1 clicked!");
    });
});
