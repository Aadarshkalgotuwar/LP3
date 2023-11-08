// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract StudentData {
    // Define a structure to represent student data
    struct Student {
        string name;
        uint256 rollNumber;
        uint256 age;
    }

    // Create a public array to store student records
    Student[] public students;

    // Constructor: This is executed only once when the contract is deployed and is empty in this case
    constructor() {}

    // Function to add a new student record
    function addStudent(string memory _name, uint256 _rollNumber, uint256 _age) public {
        // Create a new student record using the provided data
        Student memory newStudent = Student(_name, _rollNumber, _age);
        // Add the new student record to the 'students' array
        students.push(newStudent);
    }

    // Function to get the total number of students in the array
    function getStudentCount() public view returns (uint256) {
        return students.length;
    }

    // Function to get student details by index
    function getStudent(uint256 index) public view returns (string memory, uint256, uint256) {
        // Check if the provided index is within the valid range
        require(index < students.length, "Student index out of bounds");
        // Retrieve the student record at the specified index
        Student memory student = students[index];
        // Return the name, roll number, and age of the student
        return (student.name, student.rollNumber, student.age);
    }
}
