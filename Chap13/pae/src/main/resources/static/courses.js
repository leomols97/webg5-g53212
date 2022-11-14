var requestData = new Vue({
    el: '#requestData',
    data: {
        listOfCourses: [],
        courseModel: "",
    },
    mounted() {
        this.listCourses();
        console.log("the component is now mounted." );
    },
    methods: {
        listCourses: function () {
            url = "/api/coursesList";
            console.log("Appel Rest");
            axios.get(url)
                .then(function (request) {
                    requestData.listOfCourses = request.data;
                    console.log("courses", request.data );
                })
                .catch(function (error) {
                    alert("Erreur appel REST");
                });
        },
        showCourse: function() {
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