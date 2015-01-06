package controllers;

import java.util.List;

import models.Book;
import models.Course;
import models.AbstractItem;
import models.User;
import models.Video;
import models.rating.AbstractItemRating;
import models.rating.BookRating;
import models.rating.CourseRating;
import models.rating.VideoRating;
import play.i18n.Messages;
import play.mvc.Controller;
import play.mvc.Result;
import recommendationSystem.dataset.DatasetDropper;
import recommendationSystem.dataset.ExportUtils.DatasetExporter;
import views.html.admin.*;

public class AdminController extends Controller {
	private static final int PAGE_LENGTH = 20;

	public static Result adminHome() {
		return ok(admin.render());
	}

	public static Result listUsers(int page) {
		int collectionLength = User.find.findRowCount();
		int from = getStartPage(page);
		int to = getEndPage(collectionLength, from);
		List<User> allUsers = User.find.findList().subList(from, to);

		return ok(listUsers.render(allUsers, collectionLength, page,
				PAGE_LENGTH));
	}

	public static Result listCourses(int page) {
		int collectionLength = Course.find.findRowCount();
		int from = getStartPage(page);
		int to = getEndPage(collectionLength, from);
		List<Course> allCourses = Course.find.findList().subList(from, to);
		return ok(listCourses.render(allCourses, collectionLength, page,
				PAGE_LENGTH));
	}

	public static Result listBooks(int page) {
		int collectionLength = Book.find.findRowCount();
		int from = getStartPage(page);
		int to = getEndPage(collectionLength, from);
		List<Book> allbooks = Book.find.findList().subList(from, to);
		return ok(listBooks.render(allbooks, collectionLength, page,
				PAGE_LENGTH));
	}

	public static Result listVideos(int page) {
		int collectionLength = Video.find.findRowCount();
		int from = getStartPage(page);
		int to = getEndPage(collectionLength, from);
		List<Video> allVideos = Video.find.findList().subList(from, to);
		return ok(listVideos.render(allVideos, collectionLength, page,
				PAGE_LENGTH));
	}

	public static Result listAbstractItems(int page) {
		int collectionLength = AbstractItem.find.findRowCount();
		int from = getStartPage(page);
		int to = getEndPage(collectionLength, from);
		List<AbstractItem> allratings = AbstractItem.find.findList().subList(
				from, to);
		return ok(listAbstractItems.render(allratings, collectionLength, page,
				PAGE_LENGTH));
	}

	public static Result listAbstractItemsRating(int page) {
		int collectionLength = AbstractItemRating.find.findRowCount();
		int from = getStartPage(page);
		int to = getEndPage(collectionLength, from);

		List<AbstractItemRating> allratings = AbstractItemRating.find
				.findList().subList(from, to);
		return ok(listAbstractItemsRating.render(allratings, collectionLength,
				page, PAGE_LENGTH));
	}

	public static Result listCourseRating(int page) {
		int collectionLength = CourseRating.find.findRowCount();
		int from = getStartPage(page);
		int to = getEndPage(collectionLength, from);
		List<CourseRating> allratings = CourseRating.find.findList().subList(
				from, to);
		return ok(listCourseRating.render(allratings, collectionLength, page,
				PAGE_LENGTH));
	}

	public static Result listVideoRating(int page) {
		int collectionLength = VideoRating.find.findRowCount();
		int from = getStartPage(page);
		int to = getEndPage(collectionLength, from);
		List<VideoRating> allratings = VideoRating.find.findList().subList(
				from, to);
		return ok(listVideoRating.render(allratings, collectionLength, page,
				PAGE_LENGTH));
	}

	public static Result listBookRating(int page) {
		int collectionLength = BookRating.find.findRowCount();
		int from = getStartPage(page);
		int to = getEndPage(collectionLength, from);
		List<BookRating> allratings = BookRating.find.findList().subList(from,
				to);
		return ok(listBooksRating.render(allratings, collectionLength, page,
				PAGE_LENGTH));
	}



	public static Result integration() {
		return ok(integration.render());
	}
	

	private static int getEndPage(int collectionLength, int from) {
		int to = (from + PAGE_LENGTH) > collectionLength ? collectionLength
				: from + PAGE_LENGTH;
		return to;
	}

	private static int getStartPage(int page) {
		int from = (page - 1) * PAGE_LENGTH;
		return from;
	}
}
