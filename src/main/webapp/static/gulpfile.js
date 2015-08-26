var gulp = require('gulp'),
    uglify = require('gulp-uglify'),
    rename = require('gulp-rename'),
	del = require('del');	//删除 文件、文件夹

//删除
gulp.task('clean', function(cb) {
   del(['build'], cb);
});

//压缩js文件
gulp.task('js_min', function() {
   return gulp.src(['js/**/*.js'])
       		 .pipe(uglify())
       		 .pipe(gulp.dest('js'));
});



