var requestData = new Vue({
    el: '#requestData',
    data: {
        coursesList: [],
        courseModel: "",
        id: 0,
        title: "",
        ECTS: '',
        studentsList: 0,
    },
    mounted() {
        this.listCourses();
        console.log("the component is now mounted.");
    },
    methods: {
        listCourses: function () {
            url = "/api/coursesList";
            console.log("Appel Rest COURSES");
            axios.get(url)
                .then(function (request) {
                    requestData.coursesList = request.data;
                    console.log("courses", request.data);
                })
                .catch(function (error) {
                    console.log(error);
                    alert("Erreur appel rest COURSES");
                });
        },
        showCourse: function () {
            console.log(this.courseModel);
            responseData.course = this.courseModel;
        },
    },
});

var responseData = new Vue({
    el: '#responseData',
    data: {
        course: {},
    }
});