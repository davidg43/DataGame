<template>
    <div id="layout">
      <Navbar />
      <!-- Content from each .vue file will go here -->
      <slot></slot>
    </div>
  </template>
  
  <script setup>
  import Navbar from "./Navbar.vue"; // Adjust the path based on your project structure
  </script>
  
  <style scoped>
  #layout {
    min-width: 100%;
  }
  </style>