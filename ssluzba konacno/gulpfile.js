var gulp = require('gulp');
var protractor = require('gulp-protractor').protractor;

gulp.task('protractor', function() {
    return gulp.src([])
        .pipe(protractor({
            configFile: "src/test/javascript/protractor.conf.js"
        }));
});