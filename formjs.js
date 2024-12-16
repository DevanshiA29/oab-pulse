document.addEventListener("DOMContentLoaded", () => {
    const steps = document.querySelectorAll(".form-step"); // All form steps
    const nextBtn = document.querySelector(".next-btn");   // "Next" button
    const backBtn = document.querySelector(".back-btn");   // "Back" button
    const loginBtn = document.querySelector(".submit-btn"); // "Submit" button
    const thankYouBox = document.querySelector(".thank-you-box"); // Thank You Box
    let currentStep = 0; // Track current step index
  
    // Handle Next Button
    nextBtn.addEventListener("click", () => {
      steps[currentStep].classList.remove("active"); // Hide current step
      currentStep++; // Move to the next step
      steps[currentStep].classList.add("active"); // Show next step
    });
  
    // Handle Back Button
    backBtn.addEventListener("click", () => {
      steps[currentStep].classList.remove("active"); // Hide current step
      currentStep--; // Move to the previous step
      steps[currentStep].classList.add("active"); // Show previous step
    });
  
    // Handle Submit Button (Login)
    loginBtn.addEventListener("click", () => {
      // Hide all form steps
      steps.forEach(step => step.classList.remove("active"));
  
      // Show the thank-you box
      thankYouBox.style.display = "block";
    });
  });
  