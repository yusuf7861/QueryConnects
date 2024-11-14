let courses = [];

$(document).ready(function () {
    $("#id_instId").change(function () {
        loadCourses($("#id_instId").val());
    });
});

function loadCourses(instId) {
    $.ajax({
        url: 'get-courses',
        data: { instId: instId },
        success: function (coursesList) {
            courses = coursesList;
            let coursesContainer = $("#id_courses");
            coursesContainer.empty();
            $.each(courses, function (i, course) {
                let courseId = course.courseId;
                let fid = 'id_course_' + courseId;
                coursesContainer.append(`
                    <input id="${fid}" onclick="doCalculateFees('${fid}')" type="checkbox" value="${courseId}" name="courses">
                    ${course.name}
                `);
            });
            coursesContainer.append('<a style="padding-left:20px" class="txt_small" href="courses">Add New</a>');
        }
    });
}

function doCalculateFees(checkboxId) {
    let checkbox = $('#' + checkboxId);
    let fees = parseFloat($('#id_fees').val()) || 0;
    let courseId = checkboxId.split("_")[2];
    let courseFee = getCourseFee(courseId);

    if (checkbox.is(":checked")) {
        fees += parseFloat(courseFee);
    } else {
        fees -= parseFloat(courseFee);
    }

    $('#id_fees').val(fees);
}

function getCourseFee(courseId) {
    let course = courses.find(c => c.courseId == courseId);
    return course ? course.fees : 0;
}
