<template>
    <div>
      <Navbar />
      <!-- Content from each .vue file will go here -->
      <slot></slot>
    </div>
  </template>
  
  <script setup>
  import Navbar from "./Navbar.vue"; // Adjust the path based on your project structure
  </script>
  